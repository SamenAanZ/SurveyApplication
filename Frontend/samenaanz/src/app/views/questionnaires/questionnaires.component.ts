import {Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { SurveyPersistanceService } from 'src/app/services/survey-persistance.service';
import { KeycloakProviderService } from 'src/app/services/auth/keycloak-provider.service';
import { Survey } from 'src/app/models/survey';
import { ClaimType } from 'src/app/models/claim-types';

@Component({
  selector: 'app-questionnaires',
  templateUrl: './questionnaires.component.html',
  styleUrls: ['./questionnaires.component.scss']
})
export class QuestionnairesComponent implements OnInit {
  public closedSurveys: readonly Survey[] = [];
  public openSurveys: readonly Survey[] = [];

  constructor(private readonly router: Router, 
    private readonly keycloak: KeycloakProviderService,
    private readonly surveyService: SurveyPersistanceService) {
  }

  public async ngOnInit(): Promise<void> {
    const userId = this.keycloak.getTokenClaim(ClaimType.id);
    this.surveyService.getSurveysByUserId(userId).subscribe(response => {

      this.closedSurveys = response.filter(survey => survey.state == "CLOSED");
      this.openSurveys = response.filter(surveys => surveys.state == "OPEN");
    });
  }

  public viewQuestionnaireDetails(survey: Survey) {
    console.log(survey.id);
    this.router.navigate(['/questionnaires', survey.id]);
  }
}
