import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';

@Component({
  selector: 'app-user-booking',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './userbooking.html',
  styleUrls: ['./userbooking.css']
})
export class UserBookingComponent {
  court: any;
  bookingDate: string = '';
  bookingTime: string = '';
  bookingEndTime: string = '';

  constructor(private router: Router) {
    const nav = this.router.getCurrentNavigation();
    this.court = nav?.extras.state?.['court']; // ✅ fetch court object
  }

  confirmBooking() {
    if (!this.bookingDate || !this.bookingTime) {
      alert('Please select date and time!');
      return;
    }
    alert(`Booking confirmed for ${this.court.name} on ${this.bookingDate} from ${this.bookingTime} to ${this.bookingEndTime}`);
    this.router.navigate(['/user/userbooking'], { state: { court: this.court } });
  }

  makePayment() {
    if (!this.bookingDate || !this.bookingTime) {
      alert('Please confirm booking first');
      return;
    }
    alert('Redirecting to payment Page...');
    this.router.navigate(['/user/userpayment'], {
      state: {
        court: this.court,
        bookingDate: this.bookingDate,
        bookingTime: this.bookingTime,
        bookingEndTime: this.bookingEndTime,
        amount: 500 // Fixed amount for simplicity
      }

    });
  }
}
