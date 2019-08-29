import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ILove } from 'app/shared/model/UserResponse/love.model';
import { LoveService } from './love.service';

@Component({
  selector: 'jhi-love-delete-dialog',
  templateUrl: './love-delete-dialog.component.html'
})
export class LoveDeleteDialogComponent {
  love: ILove;

  constructor(private loveService: LoveService, public activeModal: NgbActiveModal, private eventManager: JhiEventManager) {}

  clear() {
    this.activeModal.dismiss('cancel');
  }

  confirmDelete(id: number) {
    this.loveService.delete(id).subscribe(response => {
      this.eventManager.broadcast({
        name: 'loveListModification',
        content: 'Deleted an love'
      });
      this.activeModal.dismiss(true);
    });
  }
}

@Component({
  selector: 'jhi-love-delete-popup',
  template: ''
})
export class LoveDeletePopupComponent implements OnInit, OnDestroy {
  private ngbModalRef: NgbModalRef;

  constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ love }) => {
      setTimeout(() => {
        this.ngbModalRef = this.modalService.open(LoveDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
        this.ngbModalRef.componentInstance.love = love;
        this.ngbModalRef.result.then(
          result => {
            this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
            this.ngbModalRef = null;
          },
          reason => {
            this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
            this.ngbModalRef = null;
          }
        );
      }, 0);
    });
  }

  ngOnDestroy() {
    this.ngbModalRef = null;
  }
}
