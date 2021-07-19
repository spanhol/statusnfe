import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PordataComponent } from './pordata.component';

describe('PordataComponent', () => {
  let component: PordataComponent;
  let fixture: ComponentFixture<PordataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PordataComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PordataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
