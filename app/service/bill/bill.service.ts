import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Bill } from 'src/app/modal/bill';
import { Observable } from 'rxjs';

@Injectable()
export class BillService {
    getBillUrl = '../../assets/json/bill.json';
    addBillUrl='http://localhost:8080/SplitApp/addBill';
    getBillListUrl='http://localhost:8080/SplitApp/getBillList';
    getGroupBalancesUrl='http://localhost:8080/SplitApp/getGroupBalances';

    constructor(private http: HttpClient) { }

getBill() {
  return this.http.get(this.getBillUrl);
}

addBill(billObject:Bill): Observable<any[]>
{
  return this.http.post<any[]>(this.addBillUrl, billObject)
}

getBillList(): Observable<any[]>
{
  return this.http.get<any[]>(this.getBillListUrl)
}

getgroupBalnces(): Observable<any[][]>
{
  return this.http.get<any[][]>(this.getGroupBalancesUrl)
}

}