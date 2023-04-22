import { Component } from '@angular/core';
import { NbMenuItem } from '@nebular/theme';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  items: NbMenuItem[] = [
    {
      title: 'Home',
      link: '/',
      icon: 'home'
    },
    {
      title: 'Questionnaires',
      link: 'questionnaires',
      icon: 'question-mark-outline',
      badge: {
        text: '3',
        status: 'warning'
      }
    }
  ]
}
