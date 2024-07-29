import { Component, OnInit, ViewChild } from '@angular/core';
import { Employee } from './employee';
import { EmployeeService } from './employee.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public title = 'Ratify';
  public employees!: Employee[];
  public editEmployee!: Employee;
  public deleteEmployeeName!: String;
  public deleteEmployeeId!: number; 
  public editEmployeeName!: String;
  public editEmployeeId!: number;
  public editEmployeeEmail!: String;
  public editEmployeePhone!: String;
  public editEmployeeJobTitle!: String;
  public editEmployeeImageURL!: String;

  constructor(private employeeService: EmployeeService){
  }

  ngOnInit() {
    this.getEmployees();
  }

  public getEmployees(): void {
    this.employeeService.getEmployees().subscribe(
      (response: Employee[]) => {
        this.employees = response;
        console.log(this.employees);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddEmloyee(addForm: NgForm): void {
    document.getElementById('add-employee-form')?.click();
    this.employeeService.addEmployee(addForm.value).subscribe(
      (response: Employee) => {
        console.log(response);
        this.getEmployees();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateEmloyee(employee: Employee): void {
    this.employeeService.updateEmployee(employee).subscribe({
      next: (response: Employee) => {
            console.log(response);
            this.getEmployees();
      }
    }




  //    (response: Employee) => {
   //     console.log(response);
   //     this.getEmployees();
   //   },
   //   (error: HttpErrorResponse) => {
   //     alert(error.message);
   //   }
    );
  }

  public onDeleteEmloyee(employeeId: number): void {
    this.employeeService.deleteEmployee(employeeId).subscribe(
      (response: void) => {
        console.log(response);
        this.getEmployees();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchEmployees(key: string): void {
    console.log(key);
    const results: Employee[] = [];
    for (const employee of this.employees) {
      if (employee.name.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || employee.email.toLowerCase().indexOf(key.toLowerCase()) !== -1
  ) {
        results.push(employee);
      }
    }
    this.employees = results;
    if (results.length === 0 || !key) {
      this.getEmployees();
    }
  }

  public onOpenModal(employee: Employee, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addEmployeeModal');
    }
    if (mode === 'edit') {
      this.editEmployee = employee;
      this.editEmployeeName = employee.name;
      this.editEmployeeId = employee.id;
      this.editEmployeeJobTitle = employee.jobTitle;
      this.editEmployeeEmail = employee.email;
      this.editEmployeeImageURL = employee.imageUrl;
      this.editEmployeePhone = employee.phone;
      button.setAttribute('data-target', '#updateEmployeeModal');
    }
    if (mode === 'delete') {
      this.deleteEmployeeName = employee.name;
      this.deleteEmployeeId = employee.id;
      button.setAttribute('data-target', '#deleteEmployeeModal');
    }
    container!.appendChild(button);
    button.click();
  }



  @ViewChild('myModal') myModal: any;
  
  public onOpenModalAdd(): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none'
    button.setAttribute('data-toggle', 'modal');
    button.setAttribute('data-target', '#addEmployeeModal');
    container!.appendChild(button);
    button.click()
    this.myModal.open();
  }

  







}

function next(value: Employee): void {
  throw new Error('Function not implemented.');
}
