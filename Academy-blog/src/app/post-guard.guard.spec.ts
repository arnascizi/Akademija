import { TestBed } from '@angular/core/testing';

import { PostGuardGuard } from './post-guard.guard';

describe('PostGuardGuard', () => {
  let guard: PostGuardGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(PostGuardGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
