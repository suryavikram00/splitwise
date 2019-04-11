import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GroupbalancesComponent } from './groupbalances.component';

describe('GroupbalancesComponent', () => {
  let component: GroupbalancesComponent;
  let fixture: ComponentFixture<GroupbalancesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GroupbalancesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GroupbalancesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
