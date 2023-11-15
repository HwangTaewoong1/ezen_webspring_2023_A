import { BarChart } from '@mui/x-charts/BarChart'; //npm install @mui/x-charts
import { PieChart } from '@mui/x-charts/PieChart';
export default function ProductInfo( props ){
    return(<>
        <div style={{ display : 'flex'}}>
            <div>
                <h3> 막대차트 </h3>
                <BarChart
                      xAxis={[
                        {
                          id: 'barCategories',
                          data: ['bar A', 'bar B', 'bar C'],
                          scaleType: 'band',
                        },
                      ]}
                      series={[
                        {
                          data: [2, 5, 3],
                        },
                      ]}
                      width={500}
                      height={300}
                    />
            </div>

            <div>
                <h3> 원형차트 </h3>
                  <PieChart
                      series={[
                        {
                          data: [
                            { id: 0, value: 10, label: 'series A' },
                            { id: 1, value: 15, label: 'series B' },
                            { id: 2, value: 20, label: 'series C' },
                          ],
                        },
                      ]}
                      width={400}
                      height={200}
                    />
            </div>

        </div>
    </>)
}