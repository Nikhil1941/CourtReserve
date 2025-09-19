import { Component, ViewChild, ElementRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './profile.html',
  styleUrls: ['./profile.css']
})
export class ProfileComponent {
  editMode = false;
  profilePic: string | null = null; // Holds profile picture

  @ViewChild('fileInput') fileInput!: ElementRef<HTMLInputElement>;

  user = {
    username: 'JohnDoe',
    email: 'johndoe@example.com',
    phone: '9876543210',
    address: '123 Street, City, Country'
  };

  profileForm: any;

  constructor(private fb: FormBuilder) {
    this.profileForm = this.fb.group({
      username: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', [Validators.required, Validators.pattern('^[0-9]{10}$')]],
      address: ['', Validators.required]
    });
  }

  enableEdit() {
    this.editMode = true;
    this.profileForm.patchValue(this.user);
  }

  saveProfile() {
    if (this.profileForm.valid) {
      this.user = { ...this.profileForm.value } as any;
      this.editMode = false;
    }
  }

  cancelEdit() {
    this.editMode = false;
  }

  // Trigger hidden file input
  triggerFileInput() {
    this.fileInput.nativeElement.click();
  }

  // Handle file selection
  onFileSelected(event: any) {
    const file = event.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onload = (e: any) => {
        this.profilePic = e.target.result; // Update profile pic preview
      };
      reader.readAsDataURL(file);
    }
  }
}
