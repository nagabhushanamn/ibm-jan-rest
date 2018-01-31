import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs';
import 'rxjs/add/operator/map';

@Injectable()
export class ProductService {

  constructor(private _http: Http) {}

  loadProducts() {
    let api = "http://localhost:8080/api/products";
//    let api = "http://localhost:3000/api/products";
    return this._http.get(api) // stream
      .map(resp => resp.json())
  }

  loadReviews(prodId) {
    let api = `http://localhost:8080/api/products/${prodId}/reviews`;
//    let api = `http://localhost:3000/api/products/${prodId}/reviews`;
    return this._http.get(api)
      .map(resp => resp.json())
  }

  submitNewReview(prodId, newReview) {
    let api = `http://localhost:8080/api/products/${prodId}/reviews`;
//    let api = `http://localhost:3000/api/products/${prodId}/reviews`;
    return this._http.post(api, newReview)
      .map(resp => resp.json())
  }

}
