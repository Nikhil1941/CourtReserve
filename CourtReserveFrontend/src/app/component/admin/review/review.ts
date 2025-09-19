import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

@Component({
  selector: 'app-review',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './review.html',
  styleUrls: ['./review.css']
})
export class ReviewComponent {
  reviews = [
    {
      username: 'John Doe',
      court: 'Tennis Court A',
      rating: 5,
      comment: 'Excellent court, well maintained!',
      date: '2025-09-01'
    },
    {
      username: 'Jane Smith',
      court: 'Badminton Court B',
      rating: 4,
      comment: 'Good lighting, but floor could be better.',
      date: '2025-09-05'
    },
    {
      username: 'David Johnson',
      court: 'Basketball Court C',
      rating: 3,
      comment: 'Average experience, needs more space.',
      date: '2025-09-08'
    }
  ];
}
