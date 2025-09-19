import { ComponentFixture, TestBed } from '@angular/core/testing';
import { UserBookingComponent } from './userbooking';
import { RouterTestingModule } from '@angular/router/testing';
import { FormsModule } from '@angular/forms';

describe('UserBookingComponent', () => {
  let component: UserBookingComponent;
  let fixture: ComponentFixture<UserBookingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserBookingComponent, RouterTestingModule, FormsModule]
    }).compileComponents();

    fixture = TestBed.createComponent(UserBookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should not confirm booking without date and time', () => {
    spyOn(window, 'alert');
    component.bookingDate = '';
    component.bookingTime = '';
    component.confirmBooking();
    expect(window.alert).toHaveBeenCalledWith('Please select date and time!');
  });

  it('should confirm booking when date and time are selected', () => {
    spyOn(window, 'alert');
    component.court = { name: 'Court A' };
    component.bookingDate = '2025-09-15';
    component.bookingTime = '10:00';
    component.confirmBooking();
    expect(window.alert).toHaveBeenCalledWith('Booking confirmed for Court A on 2025-09-15 at 10:00');
  });
});
