import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HomeComponent } from './home';
import { RouterTestingModule } from '@angular/router/testing';
import { Router } from '@angular/router';

describe('HomeComponent', () => {
  let component: HomeComponent;
  let fixture: ComponentFixture<HomeComponent>;
  let router: Router;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HomeComponent, RouterTestingModule] // ✅ include RouterTestingModule
    }).compileComponents();

    fixture = TestBed.createComponent(HomeComponent);
    component = fixture.componentInstance;
    router = TestBed.inject(Router);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should list courts with images', () => {
    expect(component.courts.length).toBeGreaterThan(0);
    expect(component.courts[0].image).toContain('.jpg'); // ✅ checks image exists
  });

  it('should navigate to booking when bookCourt is called', () => {
    const navigateSpy = spyOn(router, 'navigate');
    const court = component.courts[0];
    component.bookCourt(court);

    expect(navigateSpy).toHaveBeenCalledWith(['/booking'], {
      queryParams: { court: court.name }
    });
  });

  it('should logout and redirect to register', () => {
    const navigateSpy = spyOn(router, 'navigate');
    component.logout();

    expect(navigateSpy).toHaveBeenCalledWith(['/register']);
  });
});
