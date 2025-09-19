import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { NgModule } from '@angular/core';

@Component({
  selector: 'app-user',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './user.html',
  styleUrls: ['./user.css']
})
export class UserComponent {
  userForm: FormGroup;
  users: { username: string; email: string }[] = [];

  constructor(private fb: FormBuilder) {
    this.userForm = this.fb.group({
      username: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]]
    });
  }

  onAddUser() {
    if (this.userForm.valid) {
      this.users.push(this.userForm.value);
      this.userForm.reset();
    }
  }

  onEditUser(index: number) {
    const user = this.users[index];
    this.userForm.setValue({ username: user.username, email: user.email });
    this.users.splice(index, 1); // remove user until re-added
  }

  onDeleteUser(index: number) {
    this.users.splice(index, 1);
  }
}
