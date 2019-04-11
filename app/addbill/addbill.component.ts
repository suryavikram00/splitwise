import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

import { Bill } from '../modal/bill';
import { BillService } from '../service/Bill/bill.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addbill',
  templateUrl: './addbill.component.html',
  styleUrls: ['./addbill.component.css']
})
export class AddbillComponent implements OnInit {

  AddBillForm = new FormGroup({
    description:  new FormControl(''),
    billPrice:  new FormControl(''),
    paidBy:  new FormControl(''),
   // splitBy:  new FormControl(''),
  });

  billObject:Bill;

  constructor(private billService: BillService, private router: Router) {
    
   }

  ngOnInit() {
    this.showBill();
      
  }

  showBill() {
    this.billService.getBill()
      .subscribe((data: Bill) =>{ 
          this.billObject = {
          description: data['description'],
          billPrice:  data['billPrice'],
          paidBy:  data['paidBy']
         // splitBy:  data['splitBy'],
          
      },
      this.AddBillForm.setValue(this.billObject);  
    }
      );
      
  }

  onSubmit()
  {
    console.warn(this.AddBillForm.value);

    this.billService.addBill(this.AddBillForm.value)
    .subscribe((data:any)=>{
      console.log(data);
      this.router.navigate(['/transactiondetails']);
    });


  }

}
