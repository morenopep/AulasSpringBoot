import { Component } from '@angular/core'; //importa o pacote angular/core

@Component({
  selector: 'hello',
  template: `
    <h1>Hello World</h1>  
    `   
})

export class HelloComponent {
  title = 'clientes-app';
}
