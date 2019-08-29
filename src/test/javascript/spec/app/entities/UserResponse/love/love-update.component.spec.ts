/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { UserResponseTestModule } from '../../../../test.module';
import { LoveUpdateComponent } from 'app/entities/UserResponse/love/love-update.component';
import { LoveService } from 'app/entities/UserResponse/love/love.service';
import { Love } from 'app/shared/model/UserResponse/love.model';

describe('Component Tests', () => {
  describe('Love Management Update Component', () => {
    let comp: LoveUpdateComponent;
    let fixture: ComponentFixture<LoveUpdateComponent>;
    let service: LoveService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [UserResponseTestModule],
        declarations: [LoveUpdateComponent]
      })
        .overrideTemplate(LoveUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(LoveUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(LoveService);
    });

    describe('save', () => {
      it(
        'Should call update service on save for existing entity',
        fakeAsync(() => {
          // GIVEN
          const entity = new Love(123);
          spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
          comp.love = entity;
          // WHEN
          comp.save();
          tick(); // simulate async

          // THEN
          expect(service.update).toHaveBeenCalledWith(entity);
          expect(comp.isSaving).toEqual(false);
        })
      );

      it(
        'Should call create service on save for new entity',
        fakeAsync(() => {
          // GIVEN
          const entity = new Love();
          spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
          comp.love = entity;
          // WHEN
          comp.save();
          tick(); // simulate async

          // THEN
          expect(service.create).toHaveBeenCalledWith(entity);
          expect(comp.isSaving).toEqual(false);
        })
      );
    });
  });
});
