import { Component, signal } from '@angular/core';
import { form, FormField } from '@angular/forms/signals';

interface RentFormModel
{
    id:number;
    slujitel_id:number;
    klient_id:number;
    avtomobil_id:number;
    dataZaemane:Date | null;
    dataVrushtane:Date | null;
    broiDni:number
}

@Component({
  selector: 'add-rent',
  imports:[FormField],
  template: `<form>
    <h1>Form</h1>
<input type="number" [formField]="loginForm.id"/>
<input type="number" [formField]="loginForm.klient_id"/>
<input type="number" [formField]="loginForm.slujitel_id"/>
<input type="number" [formField]="loginForm.avtomobil_id"/>
<input type="date" [formField]="loginForm.dataZaemane"/>
<input type="date" [formField]="loginForm.dataVrushtane"/>
<input type="number" [formField]="loginForm.broiDni"/>
<input type="submit"/>

  </form>`,
})
export class AddRent {
loginModel = signal<RentFormModel>({
    id: 0,
    slujitel_id: 0,
    klient_id: 0,
    avtomobil_id: 0,
    dataZaemane: null,
    dataVrushtane: null,
    broiDni: 0
})
loginForm = form(this.loginModel);
}
