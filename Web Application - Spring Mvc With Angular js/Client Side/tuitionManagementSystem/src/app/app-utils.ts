export class TmsUtils {
  public static stringConcat(...stringsValue: string[]): string {
    let returnString = '';
    for (let stringValue of stringsValue) {
      returnString += stringValue;
    }
    return returnString;
  }
}
