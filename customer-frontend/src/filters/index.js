/**
 * '2019-11-20T07:27:52.000+0000' => 'dd.mm.yyyy'
 * @param {String} value
 */
export function formatDate(strDate) {
  if (!strDate) return '';

  const date = new Date(strDate);
  let dd = date.getDate();
  let mm = date.getMonth() + 1;
  let yy = date.getFullYear();

  if (dd < 10) dd = `0${dd}`;
  if (mm < 10) mm = `0${mm}`;

  return `${dd}.${mm}.${yy}`;
}
