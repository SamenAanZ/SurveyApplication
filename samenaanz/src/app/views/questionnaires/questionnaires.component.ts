import {Component, OnDestroy, OnInit} from '@angular/core';
import {Questionnaire} from "../../services/questionnaire";
import { Router } from '@angular/router';
import { SurveyPersistanceService } from 'src/app/services/survey-persistance.service';
import { KeycloakProviderService } from 'src/app/services/auth/keycloak-provider.service';
import { Survey } from 'src/app/models/survey';

@Component({
  selector: 'app-questionnaires',
  templateUrl: './questionnaires.component.html',
  styleUrls: ['./questionnaires.component.scss']
})
export class QuestionnairesComponent implements OnInit, OnDestroy {
  public closedSurveys: readonly Survey[] = [
    { 
      id: "75039f9e-e432-4852-b2c7-6b801f0c5ede", 
      description: "HealthMatters", 
      dueDate: "26/06/2023", 
      ownerId: "owner-id", 
      state: "Closed", 
      surveyJson: "surveyJson", 
      title: "Employee Feedback Survey"
    },
  ];

  public surveys: readonly Survey[] = [
    { 
      id: "68a96100-8cc1-4d0d-bf69-8455bae4412d", 
      description: "VitalCare Health Solutions", 
      dueDate: "26/06/2023", 
      ownerId: "owner-id", 
      state: "Open", 
      surveyJson: "surveyJson", 
      title: "Employee Health Survey"
    },
    { 
      id: "01191117-8a96-466c-8759-c88dc1fdb30a", 
      description: "Harmony Health Institute", 
      dueDate: "26/06/2023", 
      ownerId: "owner-id", 
      state: "Open", 
      surveyJson: "surveyJson", 
      title: "Workplace Health Assessment Survey"
    },
  ];

  constructor(private readonly router: Router, 
    private readonly keycloak: KeycloakProviderService,
    private readonly surveyService: SurveyPersistanceService) {
  }

  public async ngOnInit(): Promise<void> {
    // Todo:
    // - Make call to backend to get all surveys that the user is and was a part of
    // - Use the information to display a list of surveys, split them between closed and open
    
    //const userId = this.keycloakProvider.getTokenClaim(ClaimType.id);
    //this.surveys = await this.surveyService.getSurveysByUserId(userId);
  }

  public ngOnDestroy(): void {
  }

  public viewQuestionnaireDetails(questionnaire: Questionnaire) {
    console.log(questionnaire.id);
    this.router.navigate(['/questionnaires', questionnaire.id]);
  }
}
