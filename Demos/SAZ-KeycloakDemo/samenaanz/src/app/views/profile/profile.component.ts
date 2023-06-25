import { Component } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { KeycloakProfile } from 'keycloak-js';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent {
  public isLoggedIn = false;
  public userProfile: KeycloakProfile | null = null;
  public userRoles: string[] = [];
  public isInRole: boolean = false;
  public isInApiRole: boolean = false;

  constructor(private readonly keycloakService: KeycloakService) {}

  public async ngOnInit() {
    this.isLoggedIn = await this.keycloakService.isLoggedIn();

    if (this.isLoggedIn) {
      this.userProfile = await this.keycloakService.loadUserProfile();
      this.userRoles = await this.keycloakService.getUserRoles();
      this.isInRole = await this.keycloakService.isUserInRole('myrole');
      this.isInApiRole = await this.keycloakService.isUserInRole('isInApiRole');
    }
  }

  logout() : void {
    this.keycloakService.logout('http://localhost:4200');
  }
}
