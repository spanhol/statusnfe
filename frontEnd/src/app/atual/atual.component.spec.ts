import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AtualComponent } from './atual.component';

describe('AtualComponent', () => {
  let component: AtualComponent;
  let fixture: ComponentFixture<AtualComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AtualComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AtualComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
