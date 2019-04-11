import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-editbill',
  templateUrl: './editbill.component.html',
  styleUrls: ['./editbill.component.css']
})
export class EditbillComponent implements OnInit {

  
  EditBillForm = new FormGroup({
    description:  new FormControl(''),
    billPrice:  new FormControl(''),
    paidBy:  new FormControl(''),
    splitBy:  new FormControl(''),
  });

  constructor() { }

  ngOnInit() {
  }

  onSubmit()
  {
    console.warn(this.EditBillForm.value);

  }

  

}
