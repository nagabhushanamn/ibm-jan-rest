import {Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import {Http} from '@angular/http';

@Component({
  selector: 'app-view-cart',
  templateUrl: './view-cart.component.html',
  styleUrls: ['./view-cart.component.css']
})
export class ViewCartComponent implements OnInit {

  @Input()
  items: Array<any> = [];
  message: string = '';

  @Output() newOrder = new EventEmitter();

  constructor(private _http: Http) {}

  ngOnInit() {
  }

  submitNewOrder() {
    let api = "http://localhost:8081/orders";
    console.dir(this.items);
    let total = 0;
    this.items.forEach(item => {
      total += item.price;
    })
    this._http.post(api, {total_cost: total, description: 'NG- new-order today'})
      .subscribe((resp) => {
        this.items = [];
        this.message = "New Order created successfully";
        this.newOrder.emit();
      })
  }



}
