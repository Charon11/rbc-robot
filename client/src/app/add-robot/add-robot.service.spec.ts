import { TestBed, inject } from '@angular/core/testing';

import { AddRobotService } from './add-robot.service';

describe('AddRobotService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AddRobotService]
    });
  });

  it('should be created', inject([AddRobotService], (service: AddRobotService) => {
    expect(service).toBeTruthy();
  }));
});
