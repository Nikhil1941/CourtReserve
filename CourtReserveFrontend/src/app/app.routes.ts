import { Routes } from '@angular/router';
import { LoginComponent } from './component/admin/login/login';
import { BookingComponent } from './component/admin/booking/booking'
import { CourtComponent } from './component/admin/court/court';
import { UserComponent } from './component/admin/user/user';
import { PaymentComponent } from './component/admin/payment/payment';
import { ReviewComponent } from './component/admin/review/review';
import { RegisterComponent } from './component/user/register/register';
import { UserLoginComponent } from './component/user/userlogin/userlogin';
import { HomeComponent }  from './component/user/home/home';
import { DashboardComponent } from './component/admin/dashboard/dashboard';
import { UserBookingComponent  } from './component/user/userbooking/userbooking';
import { UserPaymentComponent } from './component/user/userpayment/userpayment';
import { ProfileComponent } from './component/user/profile/profile';

export const routes: Routes = [
  {
    path: 'admin',
    children: [
      { path: 'login', component: LoginComponent },   // https://localhost:8080/admin/login
      { path: 'booking', component: BookingComponent }, // https://localhost:8080/admin/booking
      { path: 'court', component: CourtComponent },     // https://localhost:8080/admin/court
      { path: 'user', component: UserComponent },       // https://localhost:8080/admin/user
      { path: 'payment', component: PaymentComponent },   // https://localhost:8080/admin/payment
      { path: 'review', component: ReviewComponent },     // https://localhost:8080/admin/review
      //{ path: 'register', component: RegisterComponent },   // https://localhost:8080/admin/register
     // { path: 'userlogin', component: UserLoginComponent },
      { path: 'dashboard', component: DashboardComponent },   // https://localhost:8080/admin/dashboard
     // { path: 'home', component: HomeComponent }, // https://localhost:8080/admin/home
      { path: '', redirectTo: 'login', pathMatch: 'full' }
       // default /admin → /admin/login
    ],
  },
  {
    path: 'user',
    children: [
      { path: 'home', component: HomeComponent },
      { path: 'register', component: RegisterComponent },
      { path: 'userlogin', component: UserLoginComponent },
      { path: 'userbooking', component: UserBookingComponent },
      { path: 'userpayment', component: UserPaymentComponent },
      { path: 'profile', component: ProfileComponent }

    ]
  },
  { path: '', redirectTo: 'admin/login', pathMatch: 'full' }, // root redirect
  { path: '**', redirectTo: 'admin/login' } // catch-all invalid routes
];
