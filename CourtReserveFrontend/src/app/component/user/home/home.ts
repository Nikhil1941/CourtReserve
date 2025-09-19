import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './home.html',
  styleUrls: ['./home.css']
})
export class HomeComponent {
  courts = [
    {
      name: 'Court A',
      type: 'Tennis',
      image: 'https://media.gettyimages.com/id/1400255587/photo/aerial-view-of-tennis-court.jpg?s=612x612&w=0&k=20&c=fACjARDPcbp_I3LpYQy9q1rKGej75FD0K516808N19A='
    },
    {
      name: 'Court B',
      type: 'Badminton',
      image: 'https://thumbs.dreamstime.com/b/badminton-court-green-floor-standard-master-tournament-118488449.jpg'
    },
    {
      name: 'Court C',
      type: 'Basketball',
      image: 'https://media.gettyimages.com/id/1388729271/photo/aerial-view-of-a-basketball-court.jpg?s=612x612&w=0&k=20&c=dCf9ZEk_RgqahcxZ5OFBrIACC2JHF4fmRr4lHmliW4g='
    },
    {
      name: 'Court D',
      type: 'Volleyball',
      image: 'https://img.freepik.com/premium-photo/empty-beach-volleyball-court-city-park-beach-volleyball-courts-available-rent-promotion-sports-lifestyle-availability-mass-sports_259471-3258.jpg?semt=ais_hybrid&w=740&q=80'
    },
    {
      name: 'Court E',
      type: 'Snooker',
      image: 'https://cdn.pixabay.com/photo/2023/01/09/09/37/snooker-7706965_640.jpg'
    },
    {
      name: 'Court F',
      type: 'Squash',
      image: 'https://us.123rf.com/450wm/mschwalm/mschwalm1401/mschwalm140100016/25175878-squash-court.jpg?ver=6'
    },
    {
      name: 'Court G',
      type: 'Table Tennis',
      image: 'https://lkmfloor.com/wp-content/uploads/2023/10/%E4%B8%8B%E8%BD%BD-3.webp'
    },
    {
      name: 'Court H',
      type: 'Cricket Nets',
      image: 'https://5.imimg.com/data5/SELLER/Default/2025/7/527756832/HG/BN/JM/2312978/cricket-net-500x500.jpg'
    }
  ];

  constructor(private router: Router) {}

  bookCourt(court: any) {
    console.log('Booking Court:', court);
    // ✅ Pass full court object via router state
    this.router.navigate(['/user/userbooking'], { state: { court } });
  }

  logout() {
    this.router.navigate(['/user/userlogin']); // redirect to user login
  }
}
