import { Component, OnInit } from '@angular/core';
import { BillService } from '../service/Bill/bill.service';
import { Bill } from '../modal/bill';


@Component({
  selector: 'app-transactiondetails',
  templateUrl: './transactiondetails.component.html',
  styleUrls: ['./transactiondetails.component.css']
})
export class TransactiondetailsComponent implements OnInit {

  billListObject:Bill[];


  constructor(private billService:BillService) { }

  ngOnInit() {
    this.getBillList();
  }

  getBillList( )
  {
    this.billService.getBillList()
    .subscribe((data:Bill[])=>{
      console.log(data);
      this.billListObject=data;
    });

  }

  onEditClick()
  {
    console.log("in edit click function");
    
  }

}
