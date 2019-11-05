import { browser, by, element } from 'protractor';

export class NewClientPage {
  navigateTo() {
    return browser.get(`${browser.baseUrl}/appointments`) as Promise<any>;
  }

  setDocumentNumber(text: string) {
    return element(by.id('documentNumberInput')).sendKeys(text);
  }

  setFullName(text: string) {
    return element(by.id('fullNameInput')).sendKeys(text);
  }

  clickSave() {
    return element(by.id('saveClientButton')).click();
  }

  snackbarExists() {
    return element(by.tagName('snack-bar-container')).isPresent();
  }
}
