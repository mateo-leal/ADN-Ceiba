import { browser, logging } from 'protractor';
import faker = require('faker');
import { AppointmentPage } from './appointment.po';
import { NewAppointmentPage } from './new-appointment.po';
import { NewClientPage } from '../client/new-client.po';

describe('Create appointment test', () => {
  let page: AppointmentPage;
  let newAppointmentPage: NewAppointmentPage;
  let newClientPage: NewClientPage;

  beforeEach(() => {
    page = new AppointmentPage();
    newAppointmentPage = new NewAppointmentPage();
    newClientPage = new NewClientPage();
  });

  it('should create a new appointment', async () => {
    await page.navigateTo();
    await page.clickNewButton();
    await newAppointmentPage.clickNewClientButton();
    await newClientPage.setDocumentNumber(faker.random.number({ min: 10000000, max: 9999999999 }));
    newClientPage.setFullName(faker.name.findName());
    await newClientPage.clickSave();
    expect(newClientPage.snackbarExists()).toBeTruthy();

  });

  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    } as logging.Entry));
  });
});
