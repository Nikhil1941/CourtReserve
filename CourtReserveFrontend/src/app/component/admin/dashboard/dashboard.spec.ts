import { ComponentFixture, TestBed } from '@angular/core/testing';
import { DashboardComponent } from './dashboard';
import { RouterTestingModule } from '@angular/router/testing';

describe('DashboardComponent', () => {
  let component: DashboardComponent;
  let fixture: ComponentFixture<DashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DashboardComponent, RouterTestingModule]
    }).compileComponents();

    fixture = TestBed.createComponent(DashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should display stats correctly', () => {
    expect(component.stats.users).toBe(120);
    expect(component.stats.courts).toBe(8);
  });
});
