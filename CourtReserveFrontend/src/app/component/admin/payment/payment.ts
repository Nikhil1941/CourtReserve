import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

@Component({
  selector: 'app-payment',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './payment.html',
  styleUrls: ['./payment.css']
})
export class PaymentComponent {
  // Dummy payment data for now
  payments = [
    { username: 'John Doe', amount: 500, method: 'Credit Card', date: '2025-09-01' },
    { username: 'Jane Smith', amount: 300, method: 'UPI', date: '2025-09-05' },
    { username: 'David Johnson', amount: 700, method: 'Cash', date: '2025-09-08' }
  ];
}
