export class DateUtils {

  public static convert12hto24h(time: string): number[] {
    let hours = Number(time.match(/^(\d+)/)[1]);
    const minutes = Number(time.match(/:(\d+)/)[1]);
    const AMPM = time.match(/\s(.*)$/)[1];
    if (AMPM === 'PM' && hours < 12) {
      hours = hours + 12;
    }
    if (AMPM === 'AM' && hours === 12) {
      hours = hours - 12;
    }
    return [hours, minutes];
  }
}
