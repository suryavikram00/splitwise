import { Component, OnInit } from '@angular/core';
import { BillService } from '../service/Bill/bill.service';

@Component({
  selector: 'app-groupbalances',
  templateUrl: './groupbalances.component.html',
  styleUrls: ['./groupbalances.component.css']
})
export class GroupbalancesComponent implements OnInit {

  constructor(private billService:BillService) { }

  ngOnInit() {
    this.getgroupBalances();
  }

  getgroupBalances( )
  {
    this.billService.getgroupBalnces()
    .subscribe((data:any[][])=>{
      console.log(data);
     
    });

  }

}
