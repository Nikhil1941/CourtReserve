import { ComponentFixture, TestBed } from '@angular/core/testing';
import { BookingComponent } from './booking';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';

describe('BookingComponent', () => {
  let component: BookingComponent;
  let fixture: ComponentFixture<BookingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        BookingComponent,
        ReactiveFormsModule,
        RouterTestingModule   // ✅ handles router navigation in tests
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(BookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
