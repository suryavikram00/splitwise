import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import { AddbillComponent } from './addbill/addbill.component';

import { TransactiondetailsComponent } from './transactiondetails/transactiondetails.component';
import { BillService } from './service/Bill/bill.service';
import { EditbillComponent } from './editbill/editbill.component';
import { GroupbalancesComponent } from './groupbalances/groupbalances.component';






@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    AddbillComponent,
    TransactiondetailsComponent,
    EditbillComponent,
    GroupbalancesComponent,
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule ,
    ReactiveFormsModule,
    HttpClientModule,
    
  ],
  providers: [BillService],
  bootstrap: [AppComponent]
})
export class AppModule { }
