/**
 * '2019-11-20T07:27:52.000+0000' => 'dd.mm.yyyy'
 * @param {String} value
 */
export function formatDate(strDate) {
  const date = new Date(strDate);
  let dd = date.getDate(),
    mm = date.getMonth() + 1,
    yy = date.getFullYear();

  if (dd < 10) dd = `0${dd}`;
  if (mm < 10) mm = `0${mm}`;

  return `${dd}.${mm}.${yy}`;
}
