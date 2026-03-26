import { Component } from '@angular/core';

@Component({
  selector: 'app-home-page',
  imports: [],
  templateUrl: './home-page.html',
  styleUrl: './home-page.css',
})
export class HomePage {
  featuredCars = [
    {
      id: 1,
      brand: 'Volkswagen',
      model: 'Golf 8',
      pricePerDay: 60,
      imageUrl: 'https://www.avtosector.com/resources/ekranna-snimka-2025-05-16-163628.png'
    },
    {
      id: 2,
      brand: 'BMW',
      model: 'Серия 3',
      pricePerDay: 120,
      imageUrl: 'https://images.unsplash.com/photo-1555215695-3004980ad54e?auto=format&fit=crop&q=80&w=400'
    },
    {
      id: 3,
      brand: 'Toyota',
      model: 'Corolla',
      pricePerDay: 55,
      imageUrl: 'https://images.unsplash.com/photo-1590362891991-f776e747a588?auto=format&fit=crop&q=80&w=400'
    }
  ];
}
