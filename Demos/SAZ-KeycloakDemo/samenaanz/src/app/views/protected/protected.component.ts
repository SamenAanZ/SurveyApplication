import { Component } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';

@Component({
  selector: 'app-protected',
  templateUrl: './protected.component.html',
  styleUrls: ['./protected.component.scss']
})
export class ProtectedComponent {
  constructor(private readonly keycloakService: KeycloakService){}

  logout() : void {
    this.keycloakService.logout('http://localhost:4200');
  }
}
