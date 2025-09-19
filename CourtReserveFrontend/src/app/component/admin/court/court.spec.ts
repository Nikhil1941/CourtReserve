import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CourtComponent } from './court';

describe('CourtComponent', () => {
  let component: CourtComponent;
  let fixture: ComponentFixture<CourtComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourtComponent]
    }).compileComponents();

    fixture = TestBed.createComponent(CourtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should add a new court', () => {
    component.courtForm.setValue({ name: 'New Court', type: 'Squash', location: 'Block C' });
    component.addCourt();
    expect(component.courts.length).toBe(3);
  });

  it('should toggle availability and generate suggestions', () => {
    const court = component.courts[0];
    court.available = true;
    component.toggleAvailability(court);
    expect(court.available).toBe(false);
    expect(component.suggestions.length).toBeGreaterThan(0);
  });

  it('should clear suggestions when court is enabled', () => {
    const court = component.courts[0];
    court.available = false;
    component.toggleAvailability(court);
    expect(court.available).toBe(true);
    expect(component.suggestions.length).toBe(0);
  });
});
