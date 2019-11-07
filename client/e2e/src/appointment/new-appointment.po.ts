import { browser, by, element } from 'protractor';

export class NewAppointmentPage {
  navigateTo() {
    return browser.get(`${browser.baseUrl}/appointments`) as Promise<any>;
  }

  setClient(text: string) {
    return element(by.id('clientInput')).sendKeys(text);
  }

  setAppointmentDate(text: string) {
    return element(by.id('appointmentDateInput')).sendKeys(text);
  }

  setAppointmentTime(text: string) {
    return element(by.id('appointmentTimeInput')).sendKeys(text);
  }

  clickNewClientButton() {
    return element(by.id('newClientButton')).click();
  }

  clickSave() {
    return element(by.id('saveAppointmentButton')).click();
  }

  snackbarExists() {
    return element(by.tagName('snack-bar-container')).isPresent();
  }
}
