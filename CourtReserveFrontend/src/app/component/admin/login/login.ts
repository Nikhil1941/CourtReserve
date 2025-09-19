import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './login.html',
  styleUrls: ['./login.css']
})
export class LoginComponent {
  loginForm: FormGroup;

  constructor(private fb: FormBuilder, private router: Router) {
    this.loginForm = this.fb.group({
      username: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  // ✅ On login go to booking page
  onSubmit() {
    if (this.loginForm.valid) {
      console.log('Login Data:', this.loginForm.value);
      // Later add backend auth here
      this.router.navigate(['/admin/dashboard']); // Redirect to dashboard on successful login
    }
  }

  // ✅ On signup link go to signup page

}
