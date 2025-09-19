import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgModule } from '@angular/core';

interface Booking {
  id: number;
  court: string;
  date: string;
  time: string;
  duration: number;
}

@Component({
  selector: 'app-booking-management',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './booking.html',
  styleUrls: ['./booking.css']
})
export class BookingComponent {
  bookings: Booking[] = [
    { id: 1, court: 'Court A', date: '2025-09-12', time: '10:00', duration: 2 },
    { id: 2, court: 'Court B', date: '2025-09-13', time: '14:00', duration: 1 }
  ];

  editMode: boolean = false;
  createMode: boolean = false;
  selectedBookingId: number | null = null;
  bookingForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.bookingForm = this.fb.group({
      court: ['', Validators.required],
      date: ['', Validators.required],
      time: ['', Validators.required],
      duration: ['', [Validators.required, Validators.min(1)]]
    });
  }

  // Open form to create new booking
  newBooking() {
    this.createMode = true;
    this.editMode = false;
    this.selectedBookingId = null;
    this.bookingForm.reset();
  }

  // Save new booking
  addBooking() {
    if (this.bookingForm.valid) {
      const newBooking: Booking = {
        id: this.bookings.length > 0 ? Math.max(...this.bookings.map(b => b.id)) + 1 : 1,
        ...this.bookingForm.value
      };
      this.bookings.push(newBooking);
      this.cancelAction();
    }
  }

  // Populate form with booking data for editing
  editBooking(booking: Booking) {
    this.editMode = true;
    this.createMode = false;
    this.selectedBookingId = booking.id;
    this.bookingForm.patchValue(booking);
  }

  // Save updated booking
  updateBooking() {
    if (this.bookingForm.valid && this.selectedBookingId !== null) {
      const index = this.bookings.findIndex(b => b.id === this.selectedBookingId);
      if (index !== -1) {
        this.bookings[index] = {
          id: this.selectedBookingId,
          ...this.bookingForm.value
        };
      }
      this.cancelAction();
    }
  }

  // Cancel both create & edit
  cancelAction() {
    this.editMode = false;
    this.createMode = false;
    this.selectedBookingId = null;
    this.bookingForm.reset();
  }

  // Delete booking
  deleteBooking(id: number) {
    this.bookings = this.bookings.filter(b => b.id !== id);
  }
}


