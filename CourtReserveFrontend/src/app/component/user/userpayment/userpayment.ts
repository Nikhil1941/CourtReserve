import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-payment',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './userpayment.html',
  styleUrls: ['./userpayment.css']
})
export class UserPaymentComponent {
  court: any;
  bookingDate: string = '';
  bookingTime: string = '';
  amount: number = 500;
  paymentMode: string = '';
  upiId: string = '';
  cardNumber: string = '';
  cardExpiry: string = '';
  cardCvv: string = '';

  constructor(private router: Router) {
    const nav = this.router.getCurrentNavigation();
    const state = nav?.extras.state;
    if (state) {
      this.court = state['court'];
      this.bookingDate = state['bookingDate'];
      this.bookingTime = state['bookingTime'];
      this.amount = state['amount'];
    }
  }

  proceedPayment() {
    if (this.paymentMode === 'UPI' && !this.upiId) {
      alert('Please enter UPI ID');
      return;
    }
    if (this.paymentMode === 'Card' && (!this.cardNumber || !this.cardExpiry || !this.cardCvv)) {
      alert('Please enter complete card details');
      return;
    }

    // Simulate redirect to payment gateway
    alert(`Redirecting to Payment Gateway...\nMode: ${this.paymentMode}`);
    this.router.navigate(['/user/payment-success'], { state: { court: this.court, amount: this.amount } });
  }
}
