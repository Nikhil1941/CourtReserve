import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-login',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './userlogin.html',
  styleUrls: ['./userlogin.css']
})
export class UserLoginComponent implements OnInit {
  loginForm!: FormGroup; // declare it but don't initialize yet

  constructor(private fb: FormBuilder, private router: Router) {}

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  onLogin() {
    if (this.loginForm.valid) {
      console.log('User Logged In:', this.loginForm.value);
      this.router.navigate(['/user/home']); // ✅ Later you can make a user home/dashboard
    }
  }

  goToRegister() {
    this.router.navigate(['/user/register']); // ✅ Go to Register Page
  }
}
