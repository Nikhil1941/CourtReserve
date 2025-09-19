import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, ReactiveFormsModule, Validators, FormGroup } from '@angular/forms';
import { NgModule } from '@angular/core';

interface Court {
  id: number;
  name: string;
  type: string;
  location: string;
  available: boolean;
}

@Component({
  selector: 'app-court',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './court.html',
  styleUrls: ['./court.css']
})
export class CourtComponent {
  courts: Court[] = [
    { id: 1, name: 'Tennis Court A', type: 'Tennis', location: 'Block A', available: true },
    { id: 2, name: 'Badminton Court B', type: 'Badminton', location: 'Block B', available: true }
  ];

  courtForm: FormGroup;
  editMode = false;
  createMode = false;
  editId: number | null = null;
  suggestions: string[] = [];

  constructor(private fb: FormBuilder) {
    this.courtForm = this.fb.group({
      name: ['', Validators.required],
      type: ['', Validators.required],
      location: ['', Validators.required]
    });
  }

  newCourt() {
    this.createMode = true;
    this.editMode = false;
    this.courtForm.reset();
  }

  addCourt() {
    if (this.courtForm.valid) {
      const newCourt: Court = {
        id: this.courts.length + 1,
        name: this.courtForm.value.name,
        type: this.courtForm.value.type,
        location: this.courtForm.value.location,
        available: true
      };
      this.courts.push(newCourt);
      this.cancelAction();
    }
  }

  editCourt(court: Court) {
    this.editMode = true;
    this.createMode = false;
    this.editId = court.id;
    this.courtForm.patchValue({
      name: court.name,
      type: court.type,
      location: court.location
    });
  }

  updateCourt() {
    if (this.courtForm.valid && this.editId !== null) {
      const index = this.courts.findIndex(c => c.id === this.editId);
      if (index > -1) {
        this.courts[index] = {
          id: this.editId,
          name: this.courtForm.value.name,
          type: this.courtForm.value.type,
          location: this.courtForm.value.location,
          available: this.courts[index].available
        };
      }
      this.cancelAction();
    }
  }

  deleteCourt(id: number) {
    this.courts = this.courts.filter(c => c.id !== id);
  }

  toggleAvailability(court: Court) {
    court.available = !court.available;

    if (!court.available) {
      this.suggestions = [
        `Try another time slot (e.g., Evening 6:00 PM)`,
        `Try another day (e.g., Tomorrow instead of Today)`,
        `Try another court (e.g., Badminton Court B if Tennis is booked)`
      ];
    } else {
      this.suggestions = [];
    }
  }

  cancelAction() {
    this.createMode = false;
    this.editMode = false;
    this.editId = null;
    this.suggestions = [];
  }
}
