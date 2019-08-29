/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { UserResponseTestModule } from '../../../../test.module';
import { LoveDetailComponent } from 'app/entities/UserResponse/love/love-detail.component';
import { Love } from 'app/shared/model/UserResponse/love.model';

describe('Component Tests', () => {
  describe('Love Management Detail Component', () => {
    let comp: LoveDetailComponent;
    let fixture: ComponentFixture<LoveDetailComponent>;
    const route = ({ data: of({ love: new Love(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [UserResponseTestModule],
        declarations: [LoveDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(LoveDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(LoveDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should call load all on init', () => {
        // GIVEN

        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.love).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
