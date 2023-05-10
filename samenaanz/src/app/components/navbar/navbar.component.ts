import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { KeycloakProfile } from 'keycloak-js';
import { angularEnvironment } from 'src/environments/environment';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  public profile: KeycloakProfile | null = null;
  constructor(private readonly keycloakService: KeycloakService){}

  async ngOnInit(): Promise<void> {
    if (await this.keycloakService.isLoggedIn())
      this.profile = await this.keycloakService.loadUserProfile();
  }

  async logout(): Promise<void> {
    await this.keycloakService.logout(angularEnvironment.url);
  }
}
