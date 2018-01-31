import {ProductService} from '../product.service';
import {Component, OnInit, Input} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from '@angular/forms'

@Component({
  selector: 'app-review-form',
  templateUrl: './review-form.component.html',
  styleUrls: ['./review-form.component.css']
})
export class ReviewFormComponent implements OnInit {

  @Input()
  product: any;

  isOpen: boolean = false
  reviewForm: FormGroup;

  constructor(private fb: FormBuilder, private productService: ProductService) {}

  ngOnInit() {
    this.reviewForm = this.fb.group({
      stars: ['1'],
      author: ['', [Validators.required, Validators.email]],
      body: ['', [Validators.required]]
    });
  }

  toggleForm() {
    this.isOpen = !this.isOpen
  }
  submitNewReview(event) {
    event.preventDefault();
    if (this.reviewForm.valid) {
      let newReview = this.reviewForm.value;
      this.productService.submitNewReview(this.product.id, newReview)
        .subscribe(review => {
          this.product.reviews.push(review);
          this.reviewForm.reset();
          this.toggleForm();
        })

    }
  }

}
