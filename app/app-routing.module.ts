import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AddbillComponent } from './addbill/addbill.component';
import { TransactiondetailsComponent } from './transactiondetails/transactiondetails.component';
import { NavbarComponent } from './navbar/navbar.component';
import { EditbillComponent } from './editbill/editbill.component';
import { GroupbalancesComponent } from './groupbalances/groupbalances.component';




const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent},
  { path: 'addbill', component: AddbillComponent},
  { path: 'groupbalances', component: GroupbalancesComponent},
  { path: 'transactiondetails',
  component: TransactiondetailsComponent,
  children: [
    {
      path: 'editbill',
      component: EditbillComponent,      
    }
  ]}
];

/*const childRoutes: Routes = [
  { path: 'transactiondetails',
  component: TransactiondetailsComponent,
  children: [
    {
      path: 'editbill',
      component: EditbillComponent,      
    }
  ]}
  
  ]
}
];*/


@NgModule({
  imports: [
    RouterModule.forRoot(routes,  { enableTracing: false }),
   // RouterModule.forChild(childRoutes )
  ],
    
  exports: [RouterModule]
})
export class AppRoutingModule { }
